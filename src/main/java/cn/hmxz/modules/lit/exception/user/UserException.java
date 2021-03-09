package cn.hmxz.modules.lit.exception.user;


import cn.hmxz.modules.lit.exception.BaseException;

/**
 * 用户信息异常类
 * 
 * @author copote
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
