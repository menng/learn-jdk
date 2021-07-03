package demo.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map实践
 */
public class MapDemo {
    public static void main(String[] args) {
        mergeDemo();
        userMerge();
    }

    /**
     * merge函数
     *
     * merge(key, value, BiFunction)
     * 当key不存在时，设置key - value。
     * 当key存在时，执行BitFunction(map.get(key), value)
     */
    public static void mergeDemo() {
        Map<String, Integer> map = new HashMap<>();
        map.put("name", 1);

        map.merge("name", 10, Integer::max);
        System.out.println("name=" + map.get("name"));

        map.merge("count", 1, (oldValue, newValue) -> oldValue * newValue);
        System.out.println("count=" + map.get("count"));

        map.merge("count", 1, Integer::sum);
        System.out.println("count=" + map.get("count"));
    }

    /**
     * merge使用场景
     * 统计每个学生的总成绩
     */
    public static void userMerge() {
        List<StudentScore> list = buildStudentScoreList();

        // 传统写法
        Map<Integer, Integer> map = new HashMap<>();
        list.forEach(e-> {
            if (map.containsKey(e.getSid())) {
                map.put(e.getSid(), e.getScore() + map.get(e.getSid()));
            } else {
                map.put(e.getSid(), e.getScore());
            }
        });

        map.keySet().forEach(e -> {
            System.out.println(map.get(e));
        });

        map.clear();
        System.out.println("---分割线---");

        // merge写法
        list.forEach(e -> {
            map.merge(e.getSid(), e.getScore(), Integer::sum);
        });
        map.values().forEach(System.out::println);
    }


    private static List<StudentScore> buildStudentScoreList() {
        List<StudentScore> list = new ArrayList<>();
        list.add(new StudentScore(1, "chinese", 110));
        list.add(new StudentScore(1, "english", 120));
        list.add(new StudentScore(1, "math", 135));
        list.add(new StudentScore(2, "chinese", 99));
        list.add(new StudentScore(2, "english", 100));
        list.add(new StudentScore(2, "math", 133));
        list.add(new StudentScore(3, "chinese", 88));
        list.add(new StudentScore(3, "english", 140));
        list.add(new StudentScore(3, "math", 90));
        list.add(new StudentScore(4, "chinese", 108));
        list.add(new StudentScore(4, "english", 123));
        list.add(new StudentScore(4, "math", 114));
        list.add(new StudentScore(5, "chinese", 116));
        list.add(new StudentScore(5, "english", 133));
        list.add(new StudentScore(5, "math", 135));

        return list;
    }
}


class StudentScore {
    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 科目
     */
    private String scoreName;

    /**
     * 成绩
     */
    private Integer score;

    public StudentScore(Integer sid, String scoreName, Integer score) {
        this.sid = sid;
        this.scoreName = scoreName;
        this.score = score;
    }

    public StudentScore() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
