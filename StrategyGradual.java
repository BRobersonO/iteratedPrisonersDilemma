import java.util.ArrayList;
import java.util.List;

/**
 * Class containing the gradual strategy.
 * @author	Mahfuz
 */
public class StrategyGradual extends Strategy
   {
  /**
   * Encoding for prober strategy.
   */

  // int iteration;
  // List<Integer> opponentMoves;
  int defect_n;// = 0;
  int punish_count;/// = 0;
  boolean isHot;// = false;
  // boolean isTitForTat;

  // 0 = defect, 1 = cooperate

   public StrategyGradual()
      {
        name = "Gradual";
          // iteration = -1;
          // opponentMoves = new ArrayList<Integer>();
          // isTitForTat = true;
      opponentLastMove = 1;
      isHot = false;
      punish_count = 0;
      defect_n = 0;
    }  /* StrategyProber */

  // public void saveOpponentMove(int move){
  //   opponentLastMove = move;
  //   opponentMoves.add(opponentLastMove);
  //     // System.out.println("Adding " + opponentLastMove);
  // }
   public int nextMove()
      {
        // iteration++;
        if(opponentLastMove == 0){
          // System.out.println("Opp Last: " + opponentLastMove);
          isHot = true;
          defect_n++;
          punish_count = defect_n;
        }

        if(isHot == true){
          punish_count--;
          if(punish_count == -2){
            isHot = false;
          }
          if(punish_count < 0){
            return 1;
          }
          return 0;
        }
        return 1;


        // if(iteration < probe.length()) {
        //     return Character.getNumericValue(probe.charAt(iteration));
        // }
        // else if(isTitForTat) {
        //     //always cooperate when playing agaisnt TitForTat
        //     // return opponentLastMove;
        //     return 1;
        // }
        // else {
        //     //Always Defect
        //     return 0;
        // }
      }

   }  /* class StrategyTitForTat */
