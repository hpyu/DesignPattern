public class VisitorTreeClient {
    public static void main(String[] args)
    {
        // VisitorTree is defined as an abstract, it can't be instantiated
        // but can assigned like below
        // here t should be a type object, not a class object
        VisitorTree<Integer> t =
                VisitorTree.branch(VisitorTree.branch(VisitorTree.leaf(1),
                                                      VisitorTree.leaf(2)),
                                                      VisitorTree.leaf(3));
        System.out.println(t.toString());
        System.out.println(t.sum());
        assert t.toString().equals("((1^2)^3)");
        assert t.sum() == 6;
    }
}
