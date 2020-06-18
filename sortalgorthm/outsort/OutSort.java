package sortalgorthm.outsort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 外部排序指的是大文件的排序，即待排序的记录存储在外存储器上，
 * 待排序的文件无法一次装入内存，
 * 需要在内存和外部存储器之间进行多次数据交换，
 * 以达到排序整个文件的目的
 */
public class OutSort {
    public static void main(String[] args) throws IOException {
        File file = new File("test/source.txt");
        BufferedReader fr = new BufferedReader(new FileReader(file));//源数据文件读取。
        final int SIZE = 10000;//这里是定义我们将源文件中以10000条记录作为单位进行分割。
        int[] nums = new int[SIZE];//临时存放分割时的记录
        List<String> fileNames = new ArrayList<>();//保存所有分割文件的名称
        int index = 0;
        while (true) {
            String num = fr.readLine();//从原文件中读取一条记录
            if (num == null) {//如果读取完毕后，进行一次排序并保存
                fileNames.add(OutSort.sortAndSave(nums, index));
                break;
            }
            nums[index] = Integer.valueOf(num);
            index++;
            if (index == SIZE) {//当nums里面读的数字到达长度边界时， test，存储
                fileNames.add(OutSort.sortAndSave(nums, index));//sortAndSave是将nums中前index条记录先快速 test，然后存入文件，最好将文件名返回。
                index = 0;//重置index
            }
        }
        fr.close();

        OutSort.mergeSort(fileNames);//将所有fileNames的文件进行合并

    }

//sortAndSave是将nums中前index条记录先快速 排序，然后存入文件，最好将文件名返回

    public static String sortAndSave(int[] nums, int size) throws IOException {
        QuickSort.sort(nums, 0, size - 1);
        String fileName = "test/sort" + System.nanoTime() + ".txt";
        File rf = new File(fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(rf));
        for (int i = 0; i < nums.length; i++) {
            bw.write(nums[i] + "\n");
        }
        bw.close();
        return fileName;
    }

    public static void mergeSort(List<String> fileNames) throws IOException {
        List<String> tempFileNames = new ArrayList<>();
        for (int i = 0; i < fileNames.size(); i++) {
            String resultFileName = "test/sort" + System.nanoTime() + ".txt";
            File resultFile = new File(resultFileName);
            tempFileNames.add(resultFileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile));

            File file1 = new File(fileNames.get(i++));
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            if (i < fileNames.size()) {
                File file2 = new File(fileNames.get(i));
                BufferedReader br2 = new BufferedReader(new FileReader(file2));
                int num1 = 0;
                int num2 = 0;
                boolean isFirst = true;
                boolean firstNext = true;
                String numVal1 = null, numVal2 = null;
                for (; ; ) {
                    if (isFirst) {
                        numVal1 = br1.readLine();
                        numVal2 = br2.readLine();
                        num1 = Integer.valueOf(numVal1);
                        num2 = Integer.valueOf(numVal2);
                        isFirst = false;
                    } else if (firstNext) {
                        numVal1 = br1.readLine();
                    } else {
                        numVal2 = br2.readLine();
                    }
                    if (numVal1 != null && numVal2 != null) {
                        if (firstNext) {
                            num1 = Integer.valueOf(numVal1);
                        } else {
                            num2 = Integer.valueOf(numVal2);
                        }
                        if (num1 < num2) {
                            bw.write(num1 + "\n");
                            firstNext = true;
                        } else {
                            bw.write(num2 + "\n");
                            firstNext = false;
                        }
                    } else {
                        if (numVal1 != null) {
                            bw.write(numVal1 + "\n");
                        }
                        if (numVal2 != null) {
                            bw.write(numVal2 + "\n");
                        }
                        break;
                    }
                }
                while (true) {
                    numVal2 = br2.readLine();
                    if (numVal2 != null) {
                        bw.write(numVal2 + "\n");
                    } else {
                        break;
                    }
                }
                br2.close();
                file2.delete();
            }
            while (true) {
                String numVal1 = br1.readLine();
                if (numVal1 != null) {
                    bw.write(numVal1 + "\n");
                } else {
                    break;
                }
            }
            br1.close();
            file1.delete();
            bw.close();
        }
        int size = tempFileNames.size();
        if (size > 1) {
            OutSort.mergeSort(tempFileNames);
        } else if (size == 1) {
            File file = new File(tempFileNames.get(0));
            file.renameTo(new File("test/result.txt"));
        }
    }
}
