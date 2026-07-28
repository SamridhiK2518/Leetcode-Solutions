class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] + nums[j] == target){
                    return {i, j};
                }
            }
        }
        // Add this line to handle the case when there is no solution
        return {};
    }
};
