package springbook.user.service;

import java.util.List;
import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserServiceImpl implements UserService {

  public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
  public static final int MIN_RECCOMEND_FOR_GOLD = 30;

  UserDao userDao;

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public User get(String id) {
    return userDao.get(id);
  }

  @Override
  public List<User> getAll() {
    return userDao.getAll();
  }

  @Override
  public void deleteAll() {
    userDao.deleteAll();
  }

  @Override
  public void update(User user) {
    userDao.update(user);
  }

  public void upgradeLevels() {
    List<User> users = userDao.getAll();
    for (User user : users) {
      if (canUpgradeLevel(user)) {
        upgradeLevel(user);
      }
    }
  }

  private boolean canUpgradeLevel(User user) {
    Level currentLevel = user.getLevel();
    switch (currentLevel) {
      case BASIC:
        return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
      case SILVER:
        return (user.getRecommend() >= MIN_RECCOMEND_FOR_GOLD);
      case GOLD:
        return false;
      default:
        throw new IllegalArgumentException("Unknown Level: " + currentLevel);
    }
  }

  protected void upgradeLevel(User user) {
    user.upgradeLevel();
    userDao.update(user);
    sendUpgradeEMail(user);
  }

  private void sendUpgradeEMail(User user) {
    /* deprecated */
  }

  public void add(User user) {
    if (user.getLevel() == null) {
      user.setLevel(Level.BASIC);
    }
    userDao.add(user);
  }
}
