class Solution {
    public int solution(int[] num_list) {
        int odd_sum = 0;
        int even_sum = 0;
        for(int i = 1; i <= num_list.length; i++){
            if(i % 2 == 0){
                even_sum += num_list[i - 1];
            }
            else {
                odd_sum += num_list[i - 1];
            }
        }
        return odd_sum > even_sum ? odd_sum : even_sum;
    }
}