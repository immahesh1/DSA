class Solution {
public:
    vector<string> codes{"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        if(digits.empty())  return res;
        else{
            res = call_letterComb(digits);
            return res;
        }
        
    }
    
    vector<string> call_letterComb(string digits){
        if (digits.size() == 0) {
            vector<string> bret;
            bret.push_back("");
            return bret;
        }
        char fc = digits[0];
        string rem = digits.substr(1, digits.size() - 1);
        vector<string> res;
        vector<string> rret = call_letterComb(rem);
        string codes_of_fc = codes[fc - '0'];
        for (auto cdsfc : codes_of_fc) {
            for (auto rc : rret) {
                res.push_back(cdsfc + rc);
            }
        }
        return res;
    }
};