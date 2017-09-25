package mapping;
import entity.NiuZa;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zzy on 2017/9/25.
 */
public interface NiuZaMapperI {
    @Insert("insert into goods(productname,price,buylink,couponlink,insertdate) values (#{productname}, #{price}, #{buylink}, #{couponlink}, #{insertdate})")
    public int add(NiuZa niuZa);

    @Delete("delete from goods where id=#{id}")
    public int deleteById(int id);

    @Update("update goods set productname=#{productname},price=#{price},buylink=#{buylink},couponlink= #{couponlink} where id=#{id}")
    public int update(NiuZa niuZa);

    @Select("select * from goods where id=#{id}")
    public NiuZa getById(int id);

    @Select("select * from goods")
    public List<NiuZa> getAll();
}
