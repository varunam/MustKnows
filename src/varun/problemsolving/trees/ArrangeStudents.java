package varun.problemsolving.trees;

/**
 * N students in a class play a game against each other where each student
 * plays against all other students in the class.
 * Find the total number of matches to be conducted.
 *
 * Design a suitable data structure for arranging the students in a line where each student would
 * have lost the match with the student in front of him.
 *
 *
 * /Video - https://youtu.be/il_t1WVLNxk
 * Question 4
 */
public class ArrangeStudents {


    public static void main(String[] args){

        //Number of matches to be conducted is nC2
        //nCk = n!/(n-1)!k!

        //Storing students in Binary Search tree such that those who lost will be left child
        //and those who won against, will be right.
        //printing students in InOrder will give the expected order of students.
    }
}
