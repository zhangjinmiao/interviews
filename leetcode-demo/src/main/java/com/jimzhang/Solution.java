package com.jimzhang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @className : Solution
 * @description:
 * @author: zhangjm
 * @create: 2020-06-22 14:49
 **/
public class Solution {

    /**
     * 两数之和
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for ( int i=0, length = nums.length; i < length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 定义单链表
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 两数相加
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 时间复杂度：O(max(m,n))
     * 空间复杂度：O(max(m,n))
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        // 进位值的变化
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            // 添加结点值
            cur.next = new ListNode(sum);
            // 移动结点
            cur = cur.next;
            // 移动链表
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 两条链表遍历完毕，进位为1，添加结点
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }


    /**
     * 242. 有效的字母异位词
     * a 在ASCII 中是97，减去 a 就是从数组第一个下标位开始
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alpha = new int[26];
        for (int i=0; i<s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }

        // Arrays.stream(alpha).allMatch(x->x==0);
        for (int i=0; i<26; i++) {
            if (alpha[i] !=0) {
                return false;
            }
        }
        return true;
    }


    private HashMap<Character,Character> mapping;

    public Solution() {
        this.mapping = new HashMap<>();
        mapping.put(')','(');
        mapping.put('}','{');
        mapping.put(']','[');
    }

    /**
     * 有效括号：使用栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (mapping.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != this.mapping.get(c)) {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
