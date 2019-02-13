class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 从小到大排序
        Arrays.sort(nums);
        int n = nums.length;
        // 空数组 全大于零 全小于零 返回空
        if(n==0 || nums[0]>0 || nums[n-1]<0) return res;
        for(int i=0;i<n;i++) {
            // 去重，排除紧挨的两个相同的数
            if(i>0 && nums[i-1]==nums[i]) continue;
            int target = 0 - nums[i];
            // 从剩下的数组首尾开始找
            int j = i+1; int k = n-1;
            while (j<k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(l);
                    // 排除相邻重复元素
                    while(j<k && nums[j] == nums[j+1]) j++;
                    while(j<k && nums[k] == nums[k-1]) k--;
                    j++;k--;
                    // 如果小于target，就将左边那个指针j右移一位
                    // 如果大于target，就将右边那个指针k左移一位
                } else if (nums[j] + nums[k] < target) j++;
                else k--;
            }
        }
        return res;
    }
}