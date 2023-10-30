package cosc201.a1;
import cosc201.unionfind.UF1;
import cosc201.unionfind.UF3;
import cosc201.unionfind.UnionFind;
//Yuki Yoshiyasu 5861229
/**
 * A modified version of this file is the only code you should submit.
 * 
 * You may add methods (and must complete some) but must not make changes
 * to the given data fields or constructor. You may, but should not need to
 * add data fields.
 * 
 * Methods that you need to complete currently just return some value of the
 * correct type. When you've written them they should return the correct answer
 * as described in the javadoc.
 * 
 * All methods should run correctly even if called more than once or in
 * sequence. This may require re-initialisation of the UnionFind data field
 * using its make method.
 * 
 * This is not necessarily the code you will use to carry out your experiments
 * (though it could be part of that). It's designed to test your understanding
 * of the UF data structure, and your ability to integrate that into code.
 * 
 */
public class PoolAnalyser {

  private final Puddles puddles;
  private final UnionFind uf;

  /**
   * Constructs a PoolAnalyser backed by the given UF instance and family of
   * puddles.
   * 
   * @param uf      a UnionFind instance
   * @param puddles a family of puddles
   */
  public PoolAnalyser(UnionFind uf, Puddles puddles) {
    this.uf = uf;
    this.puddles = puddles;
  }

  /**
   * Computes the index starting from 1 of the last essential merge in
   * the given puddles. So, for example, if there are only two puddles
   * this would always return 1 since the first merge is the only essential
   * one.
   * 
   * @return the 1-based index of the last essential merge
   */

  /**lastEssentialMerge method returns an int of the last essential merge occurred
   * creates num of groups from the num passed, loops through for pairs in the merge order
   * and if groups greater than uf groups the num of ess merges increment and groups decrement
   * if groups is 1 end and return ess
   * @return
  */
  public int lastEssentialMerge() {
    int num = puddles.count();
    uf.make(num);
    int groups = num;
    int ess = 0;
    for (int[] pair : puddles.mergeOrder()) {
        uf.union(pair[0], pair[1]);
        if (uf.groups() < groups) {
            ess++;
            groups--;
        }
        if (groups == 1) {
            break;
        }
    }
    return ess;
}
    // Complete this code so that the promise in the javadoc above is
    // satisfied.
    // return -1;

  /**
   * Computes the index starting from 1 of the first superfluous merge in
   * the given puddles. Note that if the number of puddles is at most two
   * then there are no such merges. In that case it should return -1.
   * 
   * @return the 1-based index of the first superfluous merge
   */
  
   /* The firstSuperfluousMerge returns an int.
    * The code iterates over the pairs of puddles in the merge order, merging them and keeping track of the number of groups
    If a superfluous merge is found, the method returns the index of the merge
    If no superfluous merge is found, the method returns -1
    */
  public int firstSuperfluousMerge() {
    int num = puddles.count();
    uf.make(num);
    int groups = num;
    int sup = 0;
    int index = 1;
    for(int[] pair : puddles.mergeOrder()) {
        uf.union(pair[0], pair[1]);
        if(uf.groups() < groups) {
            groups--;
        } else {
            sup++;
            if(sup == 1) {
                return index;
            }
        }
        index++;
    }
    return -1;
}

    // Complete this code so that the promise in the javadoc above is
    // satisfied.
    //return -1;
  

  /**
   * Computes the number of superfluous merges that take
   * place in the first <code>numberOfMerges</code> merges.
   * 
   * @param numberOfMerges the number of merges to make
   * @return the number of superflous merges among the first
   *         <code>numberOfMerges</code> merges.
   */
  /*
   * The countSuperfluousMerge returns an int.
   * The code initializes several integer variables to track essential and superfluous merges and iterates over pairs of puddles in the merge order
   * then merging them and updating the merge counts. 
   * The loop stops when the specified number of merges has been reached, 
   * then method returns the number of superfluous merges found within that limit
   */
  public int countSuperfluousMerges(int numberOfMerges) {
    int num = puddles.count();
    uf.make(num);
    int groups = num;
    //essential merges count isn't really needed but why not.
    int ess = 0;
    int sup = 0;
    int i= 0;
    for(int[]pair : puddles.mergeOrder()){
      uf.union(pair[0],pair[1]);
      i++;
      if(uf.groups()<groups){
        ess++;
        groups--;
      }else{
        sup++;
      }
      if(i==numberOfMerges){
        break;
      }
    }
    return sup;

  } 
    
    // Complete this code so that the promise in the javadoc above is
    // satisfied.
    //return -1;
  

  /**
   * Computes the ratio between the total number of superfluous merges
   * and essential merges at the point where the last essential merge
   * takes place.
   * 
   * @return the final ratio between superfluous and essential merges
   *         when the last essential merge takes place.
   */

   /* The superfluousRatio method returns a double.
    * The code initializes several integer and double variables to keep track of the number of essential and superfluous merges 
    and the ratio of superfluous to essential merges
    It then iterates over the pairs of puddles in the merge order, merging them and updating the merge counts accordingly
    The loop terminates when all the puddles have been merged into a single group
    Finally it returns the ratio
    */
  public double superfluousRatio() {
    int num = puddles.count();
    uf.make(num);
    int groups = num;
    double ess = 0;
    double sup = 0;
    double ratio = 0;
    for (int[] pair : puddles.mergeOrder()) {
        uf.union(pair[0], pair[1]);
        if (uf.groups() < groups) {
            ess++;
            groups--;
        } else {
            sup++;
        }if(groups==1){
          break;
        }

    }
    // sup is divided by ess and sup to take into account of all the merges whether if it was successful or not.
    ratio = sup/ess;
    return ratio;
}
}
