package OJSolution.feature.maths;

import java.util.ArrayList;
import java.util.List;

class LetterTitlePossibilitiesHuoziyinshua {
    int[] nums;

    public static void main(String[] args) {
        System.out.println(new LetterTitlePossibilitiesHuoziyinshua().numTilePossibilities("AAABBC"));
    }

    /**
     * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
     * bwftag  组合数学 任意个数的带重复元素全排列 回溯 状态ok
     *
     * @param tiles
     * @return
     */
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        nums = new int[130];
        List<Integer> tilesA = new ArrayList<>();
        for (char c : chars) {
            nums[c]++;
            if (nums[c] == 1) {
                tilesA.add(c - 0);
            }
        }
        int count = backTracking(tilesA);
        return count;
    }

    private int backTracking(List<Integer> tilesA) {
        int count = 0;
        for (Integer ind : tilesA) {
            if (nums[ind] > 0) {
                nums[ind]--;
                count++;
                count += backTracking(tilesA);
                nums[ind]++;
            }
        }
        return count;
    }
}