package com.workspace.design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepak.barr on 15/06/15.
 */
public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 20; i++)
            list.add(new Integer(i + 1).toString());

        int offset = 1;
        int fetchSize = 50;

        int toIndex = offset + fetchSize;
        toIndex = toIndex < list.size() ? toIndex : list.size();

        System.out.println("offset = " + offset);
        System.out.println("toIndex = " + toIndex);
        System.out.println(list.subList(offset, toIndex));

    }

}
