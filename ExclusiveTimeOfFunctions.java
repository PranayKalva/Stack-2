//Time Complexity - O(s)  s - logs.size().
//Space Complexity - O(n) - n - number of processes.
class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.isEmpty()) {
            return null;
        }

        int[] result = new int[n];
        int curr = 0;
        int prev = 0;
        Stack<Integer> stack = new Stack<>();
        for(String log: logs) {
            String[] process = log.split(":");
            curr = Integer.parseInt(process[2]);
            if(process[1].equals("start")){
                if(!stack.isEmpty()) {
                    result[stack.peek()] += (curr - prev);
                }
                stack.push(Integer.parseInt(process[0]));
                prev = curr;
            }
            else {
                result[stack.pop()] += (curr - prev + 1);
                prev = curr + 1;
            }
        }
        return result;
    }
}
