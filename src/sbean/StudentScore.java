package sbean;

/*
 *Created by Broderick
 * User: Broderick
 * Date: 2017/6/28
 * Time: 15:21
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
**/
public class StudentScore {
    private String name;
    private String id;
    private String rank;
    private String yuwne;
    private String shuxue;
    private String english;
    private String shengwu;
    private String wuli;
    private String huaxue;
    private String rankone;
    public StudentScore(String name, String id, String rank, String yuwne, String shuxue, String english,
                        String shengwu, String wuli, String huaxue, String rankone) {
        super();
        this.name = name;
        this.id = id;
        this.rank = rank;
        this.yuwne = yuwne;
        this.shuxue = shuxue;
        this.english = english;
        this.shengwu = shengwu;
        this.wuli = wuli;
        this.huaxue = huaxue;
        this.rankone = rankone;
    }
}
