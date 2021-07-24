class Solution {
    public String solution(String new_id) {
        // step 1
        new_id = new_id.toLowerCase();
        // step 2
        new_id = new_id.replaceAll("[^a-z0-9._-]", "");
        // step 3
        new_id = new_id.replaceAll("[.]{2,}", ".");
        // step 4
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        // step 5
        if (new_id.length() == 0)
            new_id = "a";
        // step 6
        if (new_id.length() >= 16)
            new_id = new_id.substring(0, 15).replaceAll("[.]$", "");
        // step 7
        if (new_id.length() <= 2) {
            while (new_id.length() < 3)
                new_id += new_id.charAt(new_id.length()-1);
        }
        return new_id;
    }
}