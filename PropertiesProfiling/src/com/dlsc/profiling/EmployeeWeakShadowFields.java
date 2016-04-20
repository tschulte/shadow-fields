package com.dlsc.profiling;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.ref.WeakReference;
import java.util.List;

public class EmployeeWeakShadowFields implements EmployeeIF<EmployeeWeakShadowFields> {

    public EmployeeWeakShadowFields(String name, String powers) {
        setName(name);
        setPowers(powers);
    }

    private String _name;

    private WeakReference<StringProperty> name = null;

    public final String getName() {
        checkReferences();
        StringProperty prop = name != null ? name.get() : null;
        return prop == null ? _name : prop.get();
    }

    public final void setName(String name) {
        checkReferences();
        StringProperty prop = this.name != null ? this.name.get() : null;
        if (prop == null) {
            _name = name;
        } else {
            prop.set(name);
        }
    }

    public final StringProperty nameProperty() {
        checkReferences();
        StringProperty prop = name != null ? name.get() : null;
        if (prop == null) {
            prop = new SimpleStringProperty(this, "name", _name) {
                @Override
                public void set(String newValue) {
                    super.set(newValue);
                    _name = newValue;
                }

            };
            name = new WeakReference<StringProperty>(prop);
        }
        return prop;
    }

    private String _powers;

    private WeakReference<StringProperty> powers;

    public final String getPowers() {
        checkReferences();
        StringProperty prop = powers != null ? powers.get() : null;
        return prop == null ? _powers : prop.get();
    }

    public final void setPowers(String powers) {
        checkReferences();
        StringProperty prop = this.powers != null ? this.powers.get() : null;
        if (prop == null) {
            _powers = powers;
        } else {
            prop.set(powers);
        }
    }

    public final StringProperty powersProperty() {
        checkReferences();
        StringProperty prop = powers != null ? powers.get() : null;
        if (prop == null) {
            prop = new SimpleStringProperty(this, "powers", _powers) {
                @Override
                public void set(String newValue) {
                    super.set(newValue);
                    _powers = newValue;
                }
            };
            powers = new WeakReference<StringProperty>(prop);
        }
        return prop;
    }

    private EmployeeWeakShadowFields _supervisor;

    private WeakReference<ObjectProperty<EmployeeWeakShadowFields>> supervisor;

    public final EmployeeWeakShadowFields getSupervisor() {
        checkReferences();
        ObjectProperty<EmployeeWeakShadowFields> prop = supervisor != null ? supervisor.get() : null;
        return prop == null ? _supervisor : prop.get();
    }

    public final void setSupervisor(EmployeeWeakShadowFields supervisor) {
        checkReferences();
        ObjectProperty prop = this.supervisor != null ? this.supervisor.get() : null;
        if (prop == null) {
            _supervisor = supervisor;
        } else {
            prop.set(supervisor);
        }
    }

    public final ObjectProperty<EmployeeWeakShadowFields> supervisorProperty() {
        checkReferences();
        ObjectProperty prop = supervisor != null ? supervisor.get() : null;
        if (prop == null) {
            prop = new SimpleObjectProperty<EmployeeWeakShadowFields>(this, "supervisor", _supervisor) {
                @Override
                public void set(EmployeeWeakShadowFields newValue) {
                    super.set(newValue);
                    _supervisor = newValue;
                }
            };
            supervisor = new WeakReference<ObjectProperty<EmployeeWeakShadowFields>>(prop);
        }
        return prop;
    }

    private ObservableList<EmployeeWeakShadowFields> minions;

    public final ObservableList<EmployeeWeakShadowFields> getMinions() {
        checkReferences();
        if (minions == null) {
            minions = FXCollections.observableArrayList();
        }

        return minions;
    }

    public final void setMinions(List<EmployeeWeakShadowFields> minions) {
        getMinions().setAll(minions);
    }

    /**
     * set references, which values are null to null to safe memory
     */
    private void checkReferences() {
        if (name != null && name.get() == null)
            name = null;
        if (powers != null && powers.get() == null)
            powers = null;
        if (supervisor != null && supervisor.get() == null)
            supervisor = null;

    }
}
