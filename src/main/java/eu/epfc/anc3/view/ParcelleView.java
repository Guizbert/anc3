package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Element;
import eu.epfc.anc3.model.ParcelleValue;
import eu.epfc.anc3.vm.ParcelleViewModel;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Set;

public class ParcelleView extends StackPane {
    private static final Image FARMER = new Image("farmer.png");
    private static final Image DIRT = new Image("dirt.png");
    private static final Image GRASS = new Image("grass.png");


    private ImageView imageView = new ImageView();
    private final ImageView backgroundImageView;
    private final ImageView foregroundImageView;


    public ParcelleView(ParcelleViewModel parcelleViewModel, DoubleBinding parcelleWidthProperty) {
        backgroundImageView = new ImageView();
        foregroundImageView = new ImageView();
        imageView = new ImageView();

        imageView.setPreserveRatio(false);
        imageView.fitWidthProperty().bind(parcelleWidthProperty);
        imageView.fitHeightProperty().bind(parcelleWidthProperty);
        imageView.setImage(DIRT);
        getChildren().add(imageView);
        Image img = new Image("dirt.png");
        BackgroundImage backgroundImage = new BackgroundImage(
                img,
                BackgroundRepeat.SPACE,
                BackgroundRepeat.SPACE,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true)
        );
        Background background = new Background(backgroundImage);
        this.setBackground(background);

        /*Set<ParcelleValue> pv = parcelleViewModel.elementPropertyValue();
        setParcelleImage1(imageView, pv);*/
//faire un map pour gérer l'ordre????


        //un listener sur l'ObservableSet<Element> et dedans parcourir ce truc en appelant getType() sur chaque element
        //ObservableSet<ParcelleValue> valueProp = parcelleViewModel.elementPropertyValue();
        ObservableSet<Element> valueProp = parcelleViewModel.getElementsInCell();
        //valuePropp.stream().forEach(e -> setParcelleImage1(imageView, e.getType()));

        valueProp.addListener((SetChangeListener<Element>) change -> {
            if (change.wasAdded()) {
                setParcelleImage1(imageView, change.getElementAdded().getType());
            } else if (change.wasRemoved()) {
                setParcelleImage1(imageView, change.getElementRemoved().getType());
            }

        });
        //valueProp.addListener((SetChangeListener<? super ParcelleValue>) change -> setParcelleImage1(imageView, valueProp));

        this.setOnMouseClicked(e -> parcelleViewModel.play());
    }

    void setParcelleImage1(ImageView imageView, ParcelleValue pv) {
        ObservableList<Node> observableList = getChildren();
        observableList.clear();
        switch (pv) {
            case EMPTY:
                setEmpty();
                break;
            case DIRT:
                setDirt(imageView);
                break;
            case GRASS:
                setGrass(imageView, GRASS);
                break;
            case FARMER:
                setFarmerImage(imageView);
                break;
            default:
                throw new IllegalArgumentException("Unknown parcelle value: " + pv);
        }


    }
    void setEmpty() {
        ImageView emptyCase = new ImageView(DIRT);
        emptyCase.autosize();
        emptyCase.setPreserveRatio(false);
        if (!getChildren().contains(emptyCase))
            getChildren().add(0, emptyCase);
    }
    void setDirt(ImageView imageView) {
        if (imageView.getImage() == null || imageView.getImage() == GRASS) {
            imageView.setImage(DIRT);
            imageView = new ImageView(DIRT);
            imageView.setPreserveRatio(false);
        }
    }
    void setGrass(ImageView imageView, Image image) {
        ImageView grass = new ImageView(GRASS);
        ObservableList<Node> observableList = this.getChildren();
        imageView.setImage(image);
        grass.setPreserveRatio(false);
        if (!observableList.contains(imageView)) {
            observableList.add(0, grass);
        }
    }

    void setFarmerImage(ImageView imageView) {
        ImageView farmer = new ImageView(FARMER);
        farmer.setPreserveRatio(false);
        farmer.setFitHeight(50);
        farmer.setFitWidth(50);

        ImageView background = new ImageView(GRASS);
        background.setPreserveRatio(false);
        background.setFitHeight(25);
        background.setFitWidth(25);

        ImageView foreground = new ImageView(FARMER);
        foreground.setPreserveRatio(false);
        foreground.setFitHeight(20);
        foreground.setFitWidth(20);

        ObservableList<Node> observableList = this.getChildren();
        if (!observableList.contains(background)) {
            observableList.add(background);
        }
        if (!observableList.contains(farmer)) {
            observableList.add(farmer);
        }
        if (!observableList.contains(foreground)) {
            observableList.add(foreground);
        }

        if (imageView.getImage() == GRASS) {
            foreground.setVisible(false);
        } else {
            background.setVisible(false);
        }
    }

}
