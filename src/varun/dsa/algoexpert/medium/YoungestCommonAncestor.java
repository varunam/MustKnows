package varun.dsa.algoexpert.medium;

/**
 * Youngest Common Ancestor
 * You're given three inputs, all of which are instances of an AncestralTree class that have an ancestor property
 * pointing to their youngest ancestor. The first input is the top ancestor in an ancestral tree (i.e., the only
 * instance that has no ancestor--its ancestor property points to None / null ), and the other two inputs are descendants
 * in the ancestral tree.
 * Write a function that returns the youngest common ancestor to the two descendants,
 * Note that a descendant is considered its own ancestor. So in the simple ancestral tree below, the youngest common
 * ancestor to nodes A and B is node A.
 *
 * Sample Input:
 * topAncestor: A
 * DescendantOne: E
 * DescendantTwo: I
 * Tree Structure: A
 *               /   \
 *              B     C
 *            / \    / \
 *           D   E  F   G
 *         /  \
 *        H    I
 *
 *  Sample Output: Node B
 *
 *  Time Complexity: O(h) where h is the depth of the tree.
 *  Space Complexity: O(1)
 *
 *  Problem Link: https://www.algoexpert.io/questions/Youngest%20Common%20Ancestor
 */
public class YoungestCommonAncestor {

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static void main(String[] args) {
        AncestralTree ancestralTree = new AncestralTree('A');
        AncestralTree b = new AncestralTree('B');
        AncestralTree c = new AncestralTree('C');
        AncestralTree d = new AncestralTree('D');
        AncestralTree e = new AncestralTree('E');
        AncestralTree f = new AncestralTree('F');
        AncestralTree g = new AncestralTree('G');
        AncestralTree h = new AncestralTree('H');
        AncestralTree i = new AncestralTree('I');
        ancestralTree.addAsAncestor(new AncestralTree[]{b, c});
        b.addAsAncestor(new AncestralTree[]{d, e});
        c.addAsAncestor(new AncestralTree[]{f, g});
        d.addAsAncestor(new AncestralTree[]{h, i});

        AncestralTree youngest = getYoungestCommonAncestor(ancestralTree, e, i);
        System.out.println("Youngest Ancestor is: " + youngest.name);
    }

    /*The logic is to calculate the individual depths. Once found, the one which is deeper should be navigated upwards to
    make the depth equal. Once depths are equal, navigate them together upwards and the moment they meet, he is the youngest
    ancestor.*/
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int oneDepth = 0;
        int twoDepth = 0;
        AncestralTree one = descendantOne;
        while (one.ancestor != null) {
            one = one.ancestor;
            oneDepth++;
        }

        AncestralTree two = descendantTwo;
        while (two.ancestor != null) {
            two = two.ancestor;
            twoDepth++;
        }

        int difference = oneDepth - twoDepth;
        if (difference < 0) {
            while (difference != 0) {
                descendantTwo = descendantTwo.ancestor;
                difference++;
            }
        } else {
            while (difference != 0) {
                descendantOne = descendantOne.ancestor;
                difference--;
            }
        }

        while (descendantOne != descendantTwo) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }

        return descendantTwo; // Replace this line
    }
}
