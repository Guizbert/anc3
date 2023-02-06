package eu.epfc.anc3.model;

class Position {
    private int posX, posY;
    Position(){
        posY = 0;
        posX = 0;
    }

    Position(int x, int y){
        posY = y;
        posX = x;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPos(int posX,int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    public void getPos() {
        getPosX();
        getPosY();
    }

    public void setPosY(int y) {
        this.posY = posY;
    }
}
