package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        // 调用dao完成查询
        return dao.findAll();
    }

    @Override
    public void insert(User user){
        dao.insert(user);
    }

    @Override
    public void update(User user){
        dao.update(user);
    }

    @Override
    public void delete(String id){
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if(ids != null && ids.length>0) {
            // 1.遍历数组ids
            for (String id : ids) {
                //2.调用dao删除
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        // 1.创建空PageBean
        PageBean<User> pb = new PageBean<>();
        // 2.设置参数
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if(currentPage <= 0){
            currentPage = 1;
        }
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        // 3.调用dao查询totalCount总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        // 4.调用dao查询List集合
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start,rows,condition);
        pb.setList(list);

        // 5.计算总页码
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);

        if(pb.getCurrentPage() > pb.getTotalPage()){
            pb.setCurrentPage(pb.getTotalPage());
        }
        return pb;
    }

}
