
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] b, Square start) {
      ArrayList<Square> controlledsqs = new ArrayList<Square>();
      for (int i = start.getCol()+2; i < 8; i+=2){
            controlledsqs.add(b[start.getRow()][i]); 
      }
      for (int i = start.getCol()-2; i >= 0; i-=2){
        controlledsqs.add(b[start.getRow()][i]); 
      }
      for (int i = start.getRow()+2; i < 8; i+=2){
        controlledsqs.add(b[i][start.getCol()]);
      }
      for (int i = start.getRow()-2; i >= 0; i-=2){
        controlledsqs.add(b[i][start.getCol()]);
      }
     return null;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    //Piece logic: helicopter
    //The helicopter is very similar to a rook and knight hybrid. It is able to move horizontally and vertically and jump over any pieces obstructing the path. However,
    //it comes with the drawback of only being able to land on squares of its originating color (i.e if it starts on a white square it can only occupy white squares) like
    //a bishop. 

    //precondition: the chess board and pieces have been initialized and are ready to be moved
    //postcondition: returns what moves are legal for a given piece
    public ArrayList<Square> getLegalMoves(Board b, Square start){
    	ArrayList<Square> moves = new ArrayList<Square>();
      if(b.getTurn() == b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor()){
    for (int i = start.getCol()+2; i < 8; i+=2){
      if(b.getSquareArray()[start.getRow()][i].getOccupyingPiece()!= null){
        if(b.getSquareArray()[start.getRow()][i].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor()){
          moves.add(b.getSquareArray()[start.getRow()][i]);
        }
      }
        else{
        moves.add(b.getSquareArray()[start.getRow()][i]);
      } 
    }
    for (int i = start.getCol()-2; i >= 0; i-=2){
      if(b.getSquareArray()[start.getRow()][i].getOccupyingPiece()!= null){
        if(b.getSquareArray()[start.getRow()][i].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor()){
          moves.add(b.getSquareArray()[start.getRow()][i]);
        }
      }
        else{
        moves.add(b.getSquareArray()[start.getRow()][i]);
      } 
  }
    for (int i = start.getRow()+2; i < 8; i+=2){
      if(b.getSquareArray()[i][start.getCol()].getOccupyingPiece() != null){
        if(b.getSquareArray()[i][start.getCol()].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor()){
          moves.add(b.getSquareArray()[i][start.getCol()]);
        }
      }
      else{
          moves.add(b.getSquareArray()[i][start.getCol()]);
      }
    }
    for (int i = start.getRow()-2; i >= 0; i-=2){
      if(b.getSquareArray()[i][start.getCol()].getOccupyingPiece() != null){
        if(b.getSquareArray()[i][start.getCol()].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor()){
          moves.add(b.getSquareArray()[i][start.getCol()]);
        }
      }
      else{
        moves.add(b.getSquareArray()[i][start.getCol()]);
      }
    }
    return moves;
  }
  else{
    return moves;
  }
    }
  }