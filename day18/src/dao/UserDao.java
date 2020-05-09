package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的Dao
 */
public interface UserDao {
    /**
     * 查询总的User
     * @return
     */
    public List<User> findAll();

    /**
     * 插入User
     * @param user
     */
    public void insert(User user);

    /**
     * 修改User信息
     * @param user
     */
    public void update(User user);

    /**
     * 删除一个User
     * @param id
     */
    public void delete(int id);

    /**
     * 登录查找User是否合格
     * @param username
     * @param password
     * @return
     */
    public User findUserByUsernameAndPassword(String username,String password);

    /**
     * 回显
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页显示的User
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
