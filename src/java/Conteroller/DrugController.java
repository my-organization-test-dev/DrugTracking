package Conteroller;

import Entity.Drug;
import Conteroller.util.JsfUtil;
import Conteroller.util.PaginationHelper;
import Entity.Organization;
import Entity.Tranizaction;
import Facade.DrugFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("drugController")
@SessionScoped
public class DrugController implements Serializable {

    private Drug current;
    private DataModel items = null;

    private Drug drug = new Drug();
    @EJB
    private Facade.DrugFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private Facade.TranizactionFacade tranizactionFacade;

    public DrugController() {
    }

    public Drug getSelected() {
        if (current == null) {
            current = new Drug();
            selectedItemIndex = -1;
        }
        return current;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    private DrugFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Drug) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Drug();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DrugCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Drug) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public void sell() {
        try {
            Organization bayer = drug.getCuerntOwner();
            Organization seller = ejbFacade.oldOwner(drug.getDrugId());
            float oldamount = ejbFacade.findAmount(drug.getDrugId());
            float sellamount = drug.getAmount();
            float remander = oldamount - sellamount;
            if (oldamount >= sellamount) {

                drug.setAmount(remander);
                drug.setCuerntOwner(seller);
                ejbFacade.upDate(drug);
               //set bayer id and sell amount
                drug.setAmount(sellamount);
                drug.setCuerntOwner(bayer);
                getFacade().create(drug);
                //insert in to the trancation table
                Tranizaction tr = new Tranizaction();
                tr.setAmount(20);
                tr.setBatchNo(drug.getBatchNumber());
                tr.setBayer(bayer);
                tr.setSeller(seller);
                tr.setDrugId(drug.getDrugId());
                tr.setStatus("notapprove");
                this.ejbFacade.insertTrancation(tr);
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DrugUpdated"));
            } else {
                System.out.println("mach more");
            }

        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            System.out.println(e);
        }
    }

    public String destroy() {
        current = (Drug) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DrugDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        items = new ListDataModel(getFacade().findAll());

        return items;
    }

    public List<Drug> listOfDrug() {
        List<Drug> list = ejbFacade.findActiveDrugs();
        return list;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Drug getDrug(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Drug.class)
    public static class DrugControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DrugController controller = (DrugController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "drugController");
            return controller.getDrug(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Drug) {
                Drug o = (Drug) object;
                return getStringKey(o.getDrugId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Drug.class.getName());
            }
        }

    }

    public List expirDate() {

        try {
            List a = ejbFacade.expirDateCheck();
            return a;
        } catch (Exception e) {
            return null;
        }

    }

    public void deactiveDrug() {
        try {
            drug.setStatus("deactive");
            ejbFacade.edit(drug);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DrugDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

}
