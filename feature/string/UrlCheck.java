package OJSolution.feature.string;

import java.util.Stack;

public class UrlCheck {
    /**
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
     * 两者都可以是复杂相对路径的组成部分。
     * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
     * 最后一个目录名（如果存在）不能以 / 结尾
     * 此外，规范路径必须是表示绝对路径的最短字符串。
     * *bwftag  一般特性 字符串规则 URL 状态ok
     *
     * @param path
     * @return
     */
    private String simplifyPath(String path) {
        String s = "/";
        String[] folders = path.split(s);
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < folders.length; i++) {
            String f = folders[i];
            switch (f) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(f);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(s);
            sb.append(stack.get(i));

        }
        if (stack.size() == 0) {
            return s;
        } else {
            return sb.toString();
        }
    }

    public void test() {
        System.out.println(simplifyPath("/../"));
    }
}
