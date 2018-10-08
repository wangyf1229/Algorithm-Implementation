class Solution {
    public int numFriendRequests(int[] ages) {
        int[] numInAge = new int[121];
        //If A wants to send request to B:
        //age[A] * 0.5 + 7 < age[B] <= age[A]
        for (int i = 0; i < ages.length; i++) {
            numInAge[ages[i]]++;
        }
        
        int[] sumInAge = new int[121];
        //sumInAge[i] => means the number of people who <= age i
        for (int i = 1; i < sumInAge.length; i++) {
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];
        }
        
        int requests = 0;
        for (int i = 15; i < sumInAge.length; i++) {
            if (numInAge[i] == 0) continue;
            int count = numInAge[i] * (sumInAge[i - 1] - sumInAge[i/2 + 7]); //send requests to people younger than me
            count += numInAge[i] * (numInAge[i] - 1); //people can not send friend requests to themselves
            requests += count;
        }
        
        return requests;
    }
}