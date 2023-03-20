package eu.epfc.anc3.model;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Terrain {
    //grid

    static final int GRID_HEIGHT = 15;
    static final int GRID_WIDTH = 25;

    private final Parcelle[][] matrix;


    Terrain() {
        matrix = new Parcelle[GRID_HEIGHT][];
        for (int i = 0; i < GRID_HEIGHT; ++i) {
            matrix[i] = new Parcelle[GRID_WIDTH];
            for (int j = 0; j < GRID_WIDTH; ++j) {
                matrix[i][j] = new Parcelle();
            }
        }
    }

    void resetTerrain() {
        for (int i = 0; i < GRID_HEIGHT; ++i) {
            for (int j = 0; j < GRID_WIDTH; ++j) {
                matrix[i][j].setValue(ParcelleValue.DIRT);
            }
        }
    }



    ReadOnlyObjectProperty<ParcelleValue> valueProperty(int line, int col) {
        return matrix[line][col].valueProperty();
    }

    void addElementToCell(Element e, int line, int col) {
        matrix[line][col].addElement(e);
    }
    void removeElement(ParcelleValue pv , int line, int col){
        if (containsElementType(pv, line, col))
            matrix[line][col].getElements()
                    .stream()
                    .filter(e -> e.getType().equals(pv))
                    .findFirst()
                    .ifPresent(e -> matrix[line][col].getElements().remove(e));
    }

    ObservableSet<Element> getElem(int line, int col){return matrix[line][col].getElements();}

    ObservableSet<ParcelleValue> getElemType(int line, int col){return matrix[line][col].getElementsType();}

    boolean containsElementType(ParcelleValue pv, int line, int col){
        return  matrix[line][col].getElements().stream().map(e -> e.getType()).anyMatch(x -> x == pv);
    }


    ParcelleValue getValue(int line, int col) {
        return matrix[line][col].getValue();
    }

    //etait boolean avant
    void play(int line, int col, ParcelleValue playerValue) {
        matrix[line][col].setValue(playerValue);
    }

    private ParcelleValue checkCell(int line, int column){
        ParcelleValue res = matrix[line][column].getValue();
        if (res == ParcelleValue.EMPTY)return res;
        return ParcelleValue.GRASS;
    }



    boolean isFull() {
        for(int i = 0; i < GRID_WIDTH; ++i)
            for(int j = 0; j < GRID_WIDTH; ++j)
                if(matrix[i][j].isEmpty())
                    return false;
        return true;
    }

    public void setValueOnFarm(int x, int y, ParcelleValue value) {
        matrix[x][y].setValue(value);
    }


}
