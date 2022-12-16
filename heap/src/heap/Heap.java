/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package heap;

/**
 *
 * @author w10
 */
package heap;

import java.util.Scanner;


public class Heap {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Diziye atilacak rakamlari virgül ile ayirarak giriniz: ");

    String input = sc.nextLine();

 

    //sayıları sırasıyla diziye atıyoruz

    String[] numbers = input.split(",");

    int[] array = new int[numbers.length];

    for (int i = 0; i < array.length; i++) {

      array[i] = Integer.parseInt(numbers[i]);

    }

 

   //dizinin heap olup olmadığını kontrol ediyoruz

    boolean isMinHeap = true;

    for (int i = 0; i < array.length; i++) {

      int leftChild = 2 * i + 1;

      int rightChild = 2 * i + 2;

 

      if (leftChild < array.length && array[i] > array[leftChild]) {

        isMinHeap = false;

        break;

      }

      if (rightChild < array.length && array[i] > array[rightChild]) {

        isMinHeap = false;

        break;

      }

    }

 

    // çıktımızı alıyoruz

    if (isMinHeap) {

      System.out.println("Evet, min heap'tir.");

    } else {

      System.out.println("hayır, min heap degildir.");

    }

 

    // diziyi min heap a dödürüyoruz

    for (int i = array.length / 2 - 1; i >= 0; i--) {

      heapify(array, array.length, i);

    }

 

    // min heap a dönmüş halini yazdırıyoruz

    System.out.print("Heap hali: ");

    for (int i = 0; i < array.length; i++) {

      System.out.print(array[i] + " ");

    }

    System.out.println();

  }

 

  // diziyi min heap a çeviriyoruz

  public static void heapify(int[] array, int heapSize, int i) {

    int smallest = i;

    int leftChild = 2 * i + 1;

    int rightChild = 2 * i + 2;

 

    if (leftChild < heapSize && array[leftChild] < array[smallest]) {

      smallest = leftChild;

    }

   if (rightChild < heapSize && array[rightChild] < array[smallest]) {

      smallest = rightChild;

    }

    if (smallest != i) {

      int temp = array[i];

      array[i] = array[smallest];

      array[smallest] = temp;

 

      heapify(array, heapSize, smallest);

    }

  }

}