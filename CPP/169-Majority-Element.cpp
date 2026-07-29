class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count=0;
        int n= nums.size();
        sort(nums.begin(),nums.end());
        return nums[n/2];

    }
};
