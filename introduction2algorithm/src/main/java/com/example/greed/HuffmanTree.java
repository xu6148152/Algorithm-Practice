package com.example.greed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.sort;

/**
 * Created by binea on 2016/10/25.
 */

public class HuffmanTree {

    class Node implements Comparable<Node> {

        private Node leftChild = null;
        private Data data = null;
        private Node rightChild = null;

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node [leftChild=" + leftChild + ", data=" + data
                    + ", rightChild=" + rightChild + "]";
        }

        @Override
        public int compareTo(Node o) {
            return this.data.compareTo(o.getData());
        }
    }

    class Data implements Comparable<Data> {
        // 字符
        private char c = 0;
        // 字符出现的次数
        private int frequency = 0;

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "Data [c=" + c + ", frequency=" + frequency + "]";
        }

        @Override
        public int compareTo(Data o) {
            if (this.frequency < o.getFrequency()) {
                return -1;
            } else if (this.frequency > o.getFrequency()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public class EncodeResult {
        // 字符串编码后的结果
        private String encode;
        // 字符编码对
        private Map<Character, String> letterCode;

        public EncodeResult(String encode, Map<Character, String> letterCode) {
            super();
            this.encode = encode;
            this.letterCode = letterCode;
        }

        public String getEncode() {
            return encode;
        }

        public Map<Character, String> getLetterCode() {
            return letterCode;
        }
    }

    interface HuffmanAlgorithm {
        /**
         * 编码字符串。
         *
         * @param str 指定的需要编码的字符串
         * @return 编码结果
         */
        public EncodeResult encode(String str);

        /**
         * 根据编码结果返回原来的字符串。
         *
         * @param encodeResult 原来字符串的编码结果。
         * @return 解码出来的字符串。
         */
        public String decode(EncodeResult encodeResult);
    }

    abstract class HuffmanAlgorithmAbstract implements HuffmanAlgorithm {
        @Override
        public EncodeResult encode(String str) {
            ArrayList<Node> letterList = toList(str);
            Node rootNode = createTree(letterList);
            Map<Character, String> letterCode = getLetterCode(rootNode);
            EncodeResult result = encode(letterCode, str);
            return result;
        }

        /**
         * 把一个字符串转化为节点列表
         *
         * @param letters
         * @return
         */
        private ArrayList<Node> toList(String letters) {
            ArrayList<Node> letterList = new ArrayList<>();
            Map<Character, Integer> ci = new HashMap<>();
            for (int i = 0; i < letters.length(); i++) {
                Character character = letters.charAt(i);
                if (!ci.keySet().contains(character)) {
                    ci.put(character, 1);
                } else {
                    Integer oldValue = ci.get(character);
                    ci.put(character, oldValue + 1);
                }
            }
            Set<Character> keys = ci.keySet();
            for (Character key : keys) {
                Node node = new Node();
                Data data = new Data();
                data.setC(key);
                data.setFrequency(ci.get(key));
                node.setData(data);
                letterList.add(node);
            }
            return letterList;
        }

        protected abstract Node createTree(ArrayList<Node> letterList);

        /**
         * 编码字符串。
         *
         * @param letterCode 字符/编码对集合。
         * @param letters    指定的需要编码的字符串。
         * @return 编码结果
         */
        private EncodeResult encode(Map<Character, String> letterCode, String letters) {
            StringBuilder encode = new StringBuilder();
            for (int i = 0, length = letters.length(); i < length; i++) {
                Character character = letters.charAt(i);
                encode.append(letterCode.get(character));
            }
            EncodeResult result = new EncodeResult(encode.toString(), letterCode);
            return result;
        }

        /**
         * 获得所有字符编码对
         *
         * @param
         * @return 所有字符编码对
         */
        private Map<Character, String> getLetterCode(Node rootNode) {
            Map<Character, String> letterCode = new HashMap<>();
            // 处理只有一个节点的情况
            if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
                letterCode.put(rootNode.getData().getC(), "1");
                return letterCode;

            }
            getLetterCode(rootNode, "", letterCode);
            return letterCode;
        }

        /**
         * 先序遍历哈夫曼树,获得所有字符编码对。
         *
         * @param rooNode    哈夫曼树根结点
         * @param suffix     编码前缀，也就是编码这个字符时，之前路径上的所有编码
         * @param letterCode 用于保存字符编码结果
         */
        private void getLetterCode(Node rooNode, String suffix,
                                   Map<Character, String> letterCode) {
            if (rooNode != null) {
                if (rooNode.getLeftChild() == null
                        && rooNode.getRightChild() == null) {
                    Character character = rooNode.getData().getC();
                    letterCode.put(character, suffix);

                }
                getLetterCode(rooNode.getLeftChild(), suffix + "0", letterCode);
                getLetterCode(rooNode.getRightChild(), suffix + "1", letterCode);

            }
        }

        public String decode(EncodeResult decodeResult) {
            StringBuilder decodeStr = new StringBuilder();
            Map<String, Character> decodeMap = getDecoder(decodeResult
                    .getLetterCode());
            Set<String> keys = decodeMap.keySet();
            String encode = decodeResult.getEncode();
            String temp = "";
            int i = 1;
            while (encode.length() > 0) {
                temp = encode.substring(0, i);
                if (keys.contains(temp)) {
                    Character character = decodeMap.get(temp);
                    decodeStr.append(character);
                    encode = encode.substring(i);
                    i = 1;
                } else {
                    i++;
                }
            }
            return decodeStr.toString();
        }

        /**
         * 获得解码器，也就是通过字母/编码对得到编码/字符对。
         *
         * @param letterCode
         * @return
         */
        private Map<String, Character> getDecoder(Map<Character, String> letterCode) {
            Map<String, Character> decodeMap = new HashMap<>();
            Set<Character> keys = letterCode.keySet();
            for (Character key : keys) {
                String value = letterCode.get(key);
                decodeMap.put(value, key);
            }
            return decodeMap;
        }
    }

    public class HuffmanAlgorithmImpl extends HuffmanAlgorithmAbstract {
        @Override
        protected Node createTree(ArrayList<Node> letterList) {
            init(letterList);
            while (letterList.size() != 1) {
                int size = letterList.size();
                Node nodeLeft = letterList.get(size - 1);
                Node nodeRight = letterList.get(size - 2);
                Node nodeParent = new Node();
                nodeParent.setLeftChild(nodeLeft);
                nodeParent.setRightChild(nodeRight);
                Data data = new Data();
                data.setFrequency(nodeRight.getData().getFrequency()
                        + nodeLeft.getData().getFrequency());
                nodeParent.setData(data);
                letterList.set(size - 2, nodeParent);
                letterList.remove(size - 1);
                sort(letterList);

            }
            return letterList.get(0);
        }

        /**
         * 初始化 让节点列表有序
         */
        private void init(ArrayList<Node> letterList) {
            sort(letterList);
        }
    }
}
