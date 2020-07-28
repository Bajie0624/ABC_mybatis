package com.mybatis.domain;

import java.util.List;

/**
 * @author Bajie
 * @date 2020/7/25 10:52 下午
 */
public class QueryVo {
    private User user;
    private List<Integer> ids;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
