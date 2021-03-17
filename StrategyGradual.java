import java.util.ArrayList;
import java.util.List;

/**
 * Class containing the gradual strategy.
 */
public class StrategyGradual extends Strategy
{
  /**
  * Encoding for gradual strategy.
  */

  int defect_n;
  int punish_count;
  boolean isHot;

  // 0 = defect, 1 = cooperate

  public StrategyGradual()
  {
    name = "Gradual";
    opponentLastMove = 1;
    isHot = false;
    punish_count = 0;
    defect_n = 0;
  }  /* StrategyGradual */

  public int nextMove()
  {
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
  }

}  /* class StrategyGradual */
