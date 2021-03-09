package cn.hmxz.modules.lit.exception.file;


import cn.hmxz.modules.lit.exception.BaseException;

/**
 * 文件信息异常类
 * 
 * @author copote
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
