//Hitesh Konduru
//Rook
//Piece moves anywhere into open space horizontally/vertically from its position, if its own color is blocking it it can't go past, if the opposing color is blocking it, the rook can capture it and go onto that square
import java.util.ArrayList;


//you will need to implement two functions in this file.
public class Rook extends Piece{
  

	public Rook(boolean color1, String img_file){
    super(color1, img_file);
    }

   //Precondition: a pieces color is present(a square has a piece with a certain color)
   //Postcondition: a color of a piece and the type of piece, in this case a rook, is printed out
    public String toString()
    {
   
        return "A " + super.toString() + " Rook" ;
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.

    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> moves = new ArrayList<Square>();
      int col =  start.getCol();
      int row2 = start.getRow();
      for (int row = start.getRow()+1; row < 8; row++)
      {
    
        if (board[row][col].getOccupyingPiece() == null){
          moves.add(board[row][col]);
        } 
        else if (board[row][col].getOccupyingPiece().getColor() != color){
          moves.add(board[row][col]);
          break;
        }
        else if (board[row][col].getOccupyingPiece().getColor() == color){
          moves.add(board[row][col]);
          break;
        }
        
        else {break;}

      } 
      for (int row1 = start.getRow()-1; row1 > -1; row1--)
      {
    
        if (board[row1][col].getOccupyingPiece() == null){
          moves.add(board[row1][col]);
        } else if (board[row1][col].getOccupyingPiece().getColor() != color){
          moves.add(board[row1][col]);
          break;
        }
        else if (board[row1][col].getOccupyingPiece().getColor() == color){
          moves.add(board[row1][col]);
          break;
        }
        else {break;}

      } 
     
      for (int col1 = start.getCol()-1; col1 > -1; col1--)
      {
    
        if (board[row2][col1].getOccupyingPiece() == null){
          moves.add(board[row2][col1]);
        } else if (board[row2][col1].getOccupyingPiece().getColor() != color){
          moves.add(board[row2][col1]);
          break;
        }
        else if (board[row2][col1].getOccupyingPiece().getColor() == color){
          moves.add(board[row2][col1]);
          break;
        }
        else {break;}

      } 
      for (int col2 = start.getCol()+1; col2 < 8; col2++)
      {
    
        if (board[row2][col2].getOccupyingPiece() == null){
          moves.add(board[row2][col2]);
        } else if (board[row2][col2].getOccupyingPiece().getColor() != color){
          moves.add(board[row2][col2]);
          break;
        }
        else if (board[row2][col2].getOccupyingPiece().getColor() == color){
          moves.add(board[row2][col2]);
          break;
        }
        else {break;}

      } 
    	return moves;
  
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    

    //precondition: my piece (the rook) is selected
    //postcondition: a list of possible square the piece can properly enter is created(horizontally/verically in the same row/column its in, being able to capture pieces of the other color but not its own color)

    public ArrayList<Square> getLegalMoves(Board b, Square start){
      
      ArrayList<Square> moves = new ArrayList<Square>();
      int col =  start.getCol();
      int row2 = start.getRow();
      if(b.getTurn() == b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor()){
      for (int row = start.getRow()+1; row < 8; row++)
      {
    
        if (b.getSquareArray()[row][col].getOccupyingPiece() == null){
          moves.add(b.getSquareArray()[row][col]);
        } 
        else if (b.getSquareArray()[row][col].getOccupyingPiece().getColor() != color){
          moves.add(b.getSquareArray()[row][col]);
          break;
        }
        else if (b.getSquareArray()[row][col].getOccupyingPiece().getColor() == color){
          break;
        }
          
        else {break;}

      } 
      for (int row1 = start.getRow()-1; row1 > -1; row1--)
      {
    
        if (b.getSquareArray()[row1][col].getOccupyingPiece() == null){
          moves.add(b.getSquareArray()[row1][col]);
        } 
        else if (b.getSquareArray()[row1][col].getOccupyingPiece().getColor() != color){
          moves.add(b.getSquareArray()[row1][col]);
          break;
        }
        else if (b.getSquareArray()[row1][col].getOccupyingPiece().getColor() == color){
          break;
        }
        else {break;}

      } 
     
      for (int col1 = start.getCol()-1; col1 > -1; col1--)
      {
    
        if (b.getSquareArray()[row2][col1].getOccupyingPiece() == null){
          moves.add(b.getSquareArray()[row2][col1]);
        } 
        else if (b.getSquareArray()[row2][col1].getOccupyingPiece().getColor() != color){
          moves.add(b.getSquareArray()[row2][col1]);
          break;
        }
        else if (b.getSquareArray()[row2][col1].getOccupyingPiece().getColor() == color){
          break;
        }
        else {break;}

      } 
      for (int col2 = start.getCol()+1; col2 < 8; col2++)
      {
    
        if (b.getSquareArray()[row2][col2].getOccupyingPiece() == null){
          moves.add(b.getSquareArray()[row2][col2]);
        } 
        else if (b.getSquareArray()[row2][col2].getOccupyingPiece().getColor() != color){
          moves.add(b.getSquareArray()[row2][col2]);
          break;
        }
        else if (b.getSquareArray()[row2][col2].getOccupyingPiece().getColor() == color){
          break;
        }
        else {break;}

      } 
    }
    	return moves;
    }
}