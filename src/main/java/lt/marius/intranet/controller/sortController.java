package lt.marius.intranet.controller;

import lt.marius.intranet.utils.Bubble;
import lt.marius.intranet.utils.Merge;
import lt.marius.intranet.utils.Quick;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
public class sortController {

    @RequestMapping ("/sort")
    public String sorting(){
        return "sorting";
    }

//    @RequestMapping("/sortResult")
//    public List<Integer> getNumbers(@RequestParam("nr1") Integer nr1, @RequestParam("nr2") Integer nr2){
//        List<Integer> newList = new ArrayList<>();
//        Random random  = new Random();
//        for (int i = 0; i < 100; i++) {
//            newList.add(random.nextInt(nr2 - nr1+1)+nr1);
//        }
//        Collections.sort(newList);
//        for (Integer number : newList){
//            System.out.println(number);
//        }
//        return newList;
//    }

    @RequestMapping("/sortResult")
    public String getNumbers(@RequestParam("nr1") Integer nr1, @RequestParam("nr2") Integer nr2, Model model){
        List<Integer> newList = new ArrayList<>();
        Random random  = new Random();
        for (int i = 0; i < 100000; i++) {
            newList.add(random.nextInt(nr2 - nr1+1)+nr1);
        }

        int[] array1 = newList.stream().mapToInt(i->i).toArray();
        int[] array2 = newList.stream().mapToInt(i->i).toArray();
        int[] array3 = newList.stream().mapToInt(i->i).toArray();
        Quick sorter1 = new Quick();
        Merge sorter2 = new Merge();
        Bubble sorter3 = new Bubble();



        long startTime = System.currentTimeMillis();
        sorter1.sort(array1);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

        long startTime2 = System.currentTimeMillis();
        sorter2.sort(array2);
        long endTime2   = System.currentTimeMillis();
        long totalTime2 = endTime2 - startTime2;
        System.out.println(totalTime2);

        long startTime3 = System.currentTimeMillis();
        sorter3.bubleSort(array3);
        long endTime3   = System.currentTimeMillis();
        long totalTime3 = endTime3 - startTime3;
        System.out.println(totalTime3);

        model.addAttribute("numbers", array1);
        return "result";
    }

}
