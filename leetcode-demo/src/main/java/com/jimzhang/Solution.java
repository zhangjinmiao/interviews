package com.jimzhang;

import com.jimzhang.tree.BinaryTreeDemo;

import java.util.*;

/**
 * @className : Solution
 * @description:
 * @author: zhangjm
 * @create: 2020-06-22 14:49
 **/
public class Solution {

    /**
     * tag：数组
     *
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
     * tag：数组
     *
     * 三数之和：数组遍历，sort && find 两边往中间夹
     * 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
     * 如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
     * 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
     * 当 sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
     * 时间复杂度：O(n^2)，n 为数组长度
     * 空间复杂度：O(1)
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if (nums == null || length < 3) {
            return ans;
        }
        // 从小到大排序 快排：O(nlogn)
        Arrays.sort(nums);
        for (int i=0; i<length; i++) {
            if (nums[i] > 0) {
                // 当前数字>0，则3数之和一定>0，循环结束
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                // 数字重复
                continue;
            }
            // 定义2个指针
            int L = i+1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L < R && nums[L] == nums[L+1]) {
                        // 去重
                        L++;
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        // 去重
                        R--;
                    }
                    L++;
                    R--;
                }else if (sum < 0) {
                    L++;
                }else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }

    /**
     * 定义单链表
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("arr can not be empty");
            }
            this.val = nums[0];
            ListNode cur = this;
            for (int i=1; i<nums.length; i++){
                cur.next = new ListNode(nums[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val);
                sb.append("->");
                cur =cur.next;
            }
            sb.append("NULL");
            return sb.toString();
        }
    }

    /**
     * tag：链表
     *
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
     * 242. 有效的字母异位词：数组
     * a 在ASCII 中是97，减去 a 就是从数组第一个下标位开始
     *
     * 思路：
     * 标签：哈希映射
     * 首先判断两个字符串长度是否相等，不相等则直接返回 false
     * 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
     * s 负责在对应位置增加，t 负责在对应位置减少
     * 如果哈希表的值都为 0，则二者是字母异位词
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/hua-jie-suan-fa-242-you-xiao-de-zi-mu-yi-wei-ci-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
     * tag：栈
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


    /**
     * tag：链表
     *
     * 反转单链表：迭代
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 定义节点
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next; // 临时暂存下一节点
            // 相邻节点互换
            cur.next = pre;
            pre = cur;
            cur = nextTemp;// 后移
        }
        return pre;
    }

    /**
     * tag：链表
     *
     * 两两交换链表中的节点：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode newHead = swapPairs(p2.next);
        p2.next = p1;
        p1.next = newHead;
        return p2;
    }

    public static class TreeNode {
        int val;
        BinaryTreeDemo.TreeNode left;
        BinaryTreeDemo.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 验证二叉搜索树：
     *
     * 二叉搜索树:
     *  1.节点的左子树只包含小于当前节点的数
     *  2.节点的右子树只包含大于当前节点的数
     *  3.所有左子树和右子树自身必须也是二叉搜索树
     * 时间复杂度：O()
     * 空间复杂度：O()
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        return true;
    }

}
