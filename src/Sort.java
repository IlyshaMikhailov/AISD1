import java.util.*;

public class Sort {
    public List<Integer> arr;
    public static int c;
    public static long time;

    public Sort(List<Integer> arr) {
        this.arr = arr;
        this.c = 0;
        this.time = 0;
    }

    public static int getC() {
        return c;
    }

    public static long getTime() {
        return time;
    }

    public static List<Integer>
    mergePiles(List<List<Integer>> v) {

        List<Integer> ans = new ArrayList<Integer>();
        while (true) {
            c++;
            int minu = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < v.size(); i++) {
                if (!v.get(i).isEmpty()
                        && minu > v.get(i).get(v.get(i).size()
                        - 1)) {
                    minu
                            = v.get(i).get(v.get(i).size() - 1);
                    index = i;
                    c++;
                }
            }

            if (index == -1) {
                break;
            }

            ans.add(minu);
            v.get(index).remove(v.get(index).size() - 1);
            if (v.get(index).isEmpty()) {
                v.remove(index);
            }
        }

        return ans;
    }

    public static List<Integer>
    patienceSorting(List<Integer> arr) {
        long start = System.nanoTime();
        List<List<Integer>> piles
                = new ArrayList<List<Integer>>();
        for (int i = 0; i < arr.size(); i++) {
            c++;
            if (piles.isEmpty()) {
                List<Integer> temp
                        = new ArrayList<Integer>();
                temp.add(arr.get(i));
                piles.add(temp);

            } else {
                int flag = 1;
                c++;
                for (int j = 0; j < piles.size(); j++) {
                    if (arr.get(i) < piles.get(j).get(
                            piles.get(j).size() - 1)) {
                        piles.get(j).add(arr.get(i));
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    List<Integer> temp
                            = new ArrayList<Integer>();

                    temp.add(arr.get(i));
                    piles.add(temp);
                }
            }
        }
        List<Integer> ans = mergePiles(piles);

        long end = System.nanoTime();
        time = end - start;

        return ans;
    }
}



