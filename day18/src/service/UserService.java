package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 插入数据
     * @param user
     */
    public void insert(User user);

    /**
     * 修改数据
     * @param user
     */
    public void update(User user);

    /**
     * 删除单条数据
     * @param id
     */
    public void delete(String id);

    /**
     * 登录校验
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 根据id查询，回显数据
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 删除选中
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * 分页查询 + 条件查询
     * @param currentPage
     * @param rows
     * @param condition  条件
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
