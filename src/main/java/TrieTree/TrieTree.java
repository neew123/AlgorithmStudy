package TrieTree;

public class TrieTree {

    public static class TrieNode{
        public int pass;
        public int end;
        //字符种类很多时，HashMap<Char,Node> nexts; 每个字符对应的下级节点
        public TrieNode[] nexts;
        public TrieNode(){
            pass = 0;
            end = 0;
            //nexts[0] == null  没有走向a的路
            //nexts[25] != null 有走向z的路
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for(int i = 0;i<chs.length;i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }


        //word 这个单词之前加入过几次
        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0;i<chs.length;i++){
                index = chs[i]-'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }


        //所有加入的字符串中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre){
            if(pre == null){
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0;i<chs.length;i++){
                index = chs[i]-'0';
                if(node.nexts[i] == null){
                    return 0 ;
                }
                node = node.nexts[i];
            }
            return  node.pass;
        }

        //正常删除：删除的时候考虑断路情况
        public void delete(String word){
            if(search(word)!=0){   //确定树中确实加入过word才删除
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i]-'a';
                    if( --node.nexts[index].pass == 0){
                        node.nexts[index] = null;//断了这条路径，JVM会进行内存回收
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }
    }
}
