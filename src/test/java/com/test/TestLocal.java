package com.test;

import javax.swing.text.TabableView;

/**
 * @author: ZhengTianLiang
 * @date: 2020/11/7  22:44
 * @desc: 测试类
 */
public class TestLocal {

    /**
     * @author: ZhengTianLiang
     * @date: 2020/11/7  22:45
     * @desc: 测试类
     */
    public Integer test01(int i) {
        // 5*4*3*2*1，用递归来实现
//        while(true){
//            if ((i-1)==0){
//                System.out.println(i);
//                return  i*1;
//
//            }else {
//                test01(i-1);
//            }
//        }

        if (i == 1) {
            return 1;
        } else
            return test01(i - 1) + i;

//        boolean flag = true;
//
//        do {
//            if (i==1){
//                return 1;
//            }else {
//               return test01(i-1)+i;
//            }
//        }while (flag);

    }


    public static void main(String[] args) {
        TestLocal testLocal = new TestLocal();
        Integer integer = testLocal.test01(5);
        System.out.println(integer);
    }
}
