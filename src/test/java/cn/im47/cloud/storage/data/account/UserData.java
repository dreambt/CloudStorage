package cn.im47.cloud.storage.data.account;

import cn.im47.cloud.storage.common.entity.account.Group;
import cn.im47.cloud.storage.common.entity.account.Permission;
import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.security.ShiroDbRealm;
import com.google.common.collect.Lists;
import org.springside.modules.test.data.RandomData;

import java.util.Date;
import java.util.List;

/**
 * User相关实体测试数据生成.
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-21
 * Time: 下午7:01
 */
public class UserData {

    private static final String UserSuffix = "User";
    private static final String DEFAULT_PASSWORD = "123456";

    private static List<Group> defaultGroupList = null;
    private static List<String> defaultPermissionList = null;

    public static User getRandomUser() {
        String username = RandomData.randomName(UserSuffix);

        User user = new User();
        user.setId(9999999L);
        user.setEmail(username + "@sdufe.edu.cn");
        user.setUsername(username);
        user.setPlainPassword(DEFAULT_PASSWORD);

        // 加密密码
        ShiroDbRealm shiroDbRealm = new ShiroDbRealm();
        ShiroDbRealm.HashPassword hashPassword = shiroDbRealm.encrypt(user.getPlainPassword());
        user.setSalt(hashPassword.getSalt());
        user.setPassword(hashPassword.getPassword());
        user.setStatus(true);
        user.setPhotoURL("default.jpg");
        user.setTimeOffset("aa");
        user.setLastIP(1L);
        user.setLastTime(new Date());
        user.setLastActTime(new Date());
        return user;
    }

    public static User getRandomUserWithGroup() {
        User user = getRandomUser();
        user.setGroupList(getRandomDefaultGroup());
        return user;
    }

    public static Group getRandomGroup() {
        Group group = new Group();
        group.setGroupName(RandomData.randomName("Group"));
        return group;
    }

    public static List<Group> getRandomGroupWithPermissions() {
        List<Group> groupList = Lists.newArrayList();
        Group group = getRandomGroup();
        group.getPermissionList().addAll(getRandomDefaultPermissionList());
        groupList.add(group);
        return groupList;
    }

    public static List<Group> getDefaultGroupList() {
        if (defaultGroupList == null) {
            defaultGroupList = Lists.newArrayList();
            defaultGroupList.add(new Group(1L, "管理员"));
            defaultGroupList.add(new Group(2L, "用户"));
        }
        return defaultGroupList;
    }

    public static List<Group> getRandomDefaultGroup() {
        return RandomData.randomSome(getDefaultGroupList());
    }

    public static List<String> getDefaultPermissionList() {
        if (defaultPermissionList == null) {
            defaultPermissionList = Lists.newArrayList();
            for (Permission permission : Permission.values()) {
                defaultPermissionList.add(permission.getValue());
            }
        }
        return defaultPermissionList;
    }

    public static List<String> getRandomDefaultPermissionList() {
        return RandomData.randomSome(getDefaultPermissionList());
    }
}