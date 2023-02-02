package eu.epfc.anc3.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Parcelle {
    //cellule
    private final ObjectProperty<ParcelleValue> value = new SimpleObjectProperty<>(ParcelleValue.EMPTY);

    ParcelleValue getValue() {
        return value.getValue();
    }
    void setValue(ParcelleValue value) {
        if(this.value.get() !=ParcelleValue.EMPTY)
            this.value.setValue(value); //enleve grass
        this.value.setValue(value); //met grass;.
    }

    ReadOnlyObjectProperty<ParcelleValue> valueProperty() {
        return value;
    }


}
