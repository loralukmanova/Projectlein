package bg.smg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;



public class MainFrame extends javax.swing.JFrame implements ActionListener{
    private javax.swing.JComboBox<String> MethodsComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton sortBtn;
    private GraphicElement[] images;
    private String sortMethod;
private int delay=1000;

   MainFrame(){
     initComponents();
      loadData();
     loadImages();
       }
    public static void main(String args[]) {

        MainFrame frame = new MainFrame();
        frame.setVisible(true);

    }
private void loadData(){
        images=new GraphicElement[5];
        GraphicElement g1 = new GraphicElement("Image1.png", 5);
        GraphicElement g2 = new GraphicElement("Image2.png", 4);
        GraphicElement g3 = new GraphicElement("Image3.png",3);
        GraphicElement g4 = new GraphicElement("Image4.png", 2);
        GraphicElement g5 = new GraphicElement("Image5.png", 1);

        images[0]=g1;
        images[1] = g2;
        images[2] = g3;
        images[3] = g4;
        images[4] = g5;
    }
 private void   loadImages(){
     Path resourceDirectory = Paths.get("src","resources");
     String absolutePath = resourceDirectory.toFile().getAbsolutePath();
     int x ;
     x=10;
     for (int i = 0; i < 5; i++) {

         ImageIcon imgIcon = new ImageIcon(absolutePath+"/"+images[i].getImg());

         JLabel imgLbl = new JLabel();

         imgLbl.setIcon(imgIcon);

         imgLbl.setSize(imgIcon.getIconWidth(), imgIcon.getIconHeight());

         imgLbl.setBounds(x, 50, imgIcon.getIconWidth(), imgIcon.getIconHeight());
         jPanel2.add(imgLbl);


         x +=imgIcon.getIconWidth();}
   }


   private void initComponents(){
        jPanel1 = new javax.swing.JPanel();
        MethodsComboBox = new javax.swing.JComboBox<>();
        sortBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
       MethodsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BubbleSort", "InsertionSort", "SelectionSort", "MergeSort", "QuickSort", "HeapSort" }));
       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       sortBtn.setText("Sort");
       sortBtn.addActionListener(this);
       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(jPanel1Layout.createSequentialGroup()
                               .addGap(26, 26, 26)
                               .addComponent(MethodsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                               .addComponent(sortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addGap(51, 51, 51))
       );
       jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(jPanel1Layout.createSequentialGroup()
                               .addGap(19, 19, 19)
                               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                       .addComponent(sortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                       .addComponent(MethodsComboBox))
                               .addContainerGap(28, Short.MAX_VALUE))
       );

       javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
       jPanel2.setLayout(jPanel2Layout);
       jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGap(0, 725, Short.MAX_VALUE)
       );
       jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGap(0, 235, Short.MAX_VALUE)
       );

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(layout.createSequentialGroup()
                               .addContainerGap()
                               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                               .addContainerGap())
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addGroup(layout.createSequentialGroup()
                                       .addContainerGap()
                                       .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                       .addContainerGap()))
       );
       layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(layout.createSequentialGroup()
                               .addContainerGap()
                               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addContainerGap(261, Short.MAX_VALUE))
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                       .addContainerGap(112, Short.MAX_VALUE)
                                       .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                       .addContainerGap()))
       );

       pack();
   }

    public void actionPerformed(ActionEvent e) {
        sortMethod = MethodsComboBox.getSelectedItem().toString();
        switch (sortMethod) {
            case "BubbleSort":

                BubbleSort(images);


                break;
            case "SelectionSort":
                SelectionSort(images);
                break;
            case "InsertionSort":
                InsertionSort(images);
                break;
            case "QuickSort":
                QuickSort(images, 0, 4);
                break;
            case "MergeSort":
                MergeSort(images);
                break;
            case "HeapSort":
                HeapSort(images);
                break;
        }
    }

    public void BubbleSort(GraphicElement[] list) {

       //
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    GraphicElement temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    jPanel2.removeAll();
                    loadImages();
                    jPanel2.repaint();

                }
            }
        }
    }

    public void SelectionSort(GraphicElement[] list) {
        for (int i = 0; i < list.length - 1; i++) {

            GraphicElement currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;

            }
           jPanel2.removeAll();
            loadImages();
            jPanel2.repaint();
        }
    }

    public void InsertionSort(GraphicElement[] list) {
        for (int i = 1; i < list.length; i++) {
            GraphicElement currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && (list[k].compareTo(currentElement) > 0); k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
            jPanel2.removeAll();
            loadImages();
            jPanel2.repaint();
        }
    }

    public void MergeSort(GraphicElement[] list) {
        if (list.length > 1) {
            GraphicElement[] firstHalf = new GraphicElement[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            MergeSort(firstHalf);
            int secondHalfLength = list.length - list.length / 2;
            GraphicElement[] secondHalf = new GraphicElement[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            MergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }
    }

    public void QuickSort(GraphicElement[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            QuickSort(list, first, pivotIndex - 1);
            QuickSort(list, pivotIndex + 1, last);
        }

    }

    public void HeapSort(GraphicElement[] list) {

        Heap heap = new Heap();

        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
            jPanel2.removeAll();
            loadImages();
            jPanel2.repaint();
        }

    }

    public void merge(GraphicElement[] list1, GraphicElement[] list2, GraphicElement[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].compareTo(list2[current2]) < 0) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }
        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }
        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
        jPanel2.removeAll();
        loadImages();
        jPanel2.repaint();
    }

    private int partition(GraphicElement[] list, int first, int last) {
        GraphicElement pivot = list[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            while (low <= high && (list[low].compareTo(pivot)) <= 0) {
                low++;
            }
            while (low <= high && (list[high].compareTo(pivot)) > 0) {
                high--;
            }
            if (high > low) {
                GraphicElement temp = list[high];
                list[high] = list[low];
                list[low] = temp;
                jPanel2.removeAll();
                loadImages();
                jPanel2.repaint();
            }
        }
        while (high > first && list[high].compareTo(pivot) >= 0) {
            high--;
        }
        if (pivot.compareTo(list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            jPanel2.removeAll();
            loadImages();
            jPanel2.repaint();
            return high;

        } else {
            return first;
        }
    }
}
