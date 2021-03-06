package com.kh.bom.product.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.bom.inquiry.model.vo.Inquiry;
import com.kh.bom.product.model.vo.Product;
import com.kh.bom.review.model.vo.Review;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Inquiry> inquiryList(SqlSession session, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("inquiry.inquiryList",null,new RowBounds((cPage-1)*numPerpage,numPerpage));
	}

	@Override
	public int inquiryCount(SqlSession session) {
		return session.selectOne("inquiry.inquiryCount");
	}
	
	@Override
	public List<Review> reviewList(SqlSession session, int cPage, int numPerpage) {
		return session.selectList("review.reviewList",null,new RowBounds((cPage-1)*numPerpage,numPerpage));
	}

	@Override
	public int reviewCount(SqlSession session) {
		return session.selectOne("review.reviewCount");
	}

	@Override
	public int productCount(SqlSession session, String category) {
		Map<String,String> map=new HashMap();
		map.put("category", category);
		return session.selectOne("product.count",map);
	}
	@Override
	public int countSale(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("product.countSale");
	}
	@Override
	public List<Product> selectProductList(SqlSession session,int cPage,int numPerPage,String sort,String category) {
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap();
		map.put("sort", sort);
		map.put("category", category);
		return session.selectList("product.productList",map,new RowBounds((cPage-1)*numPerPage,numPerPage));
	}
	@Override
	public List<Product> selectNewCateList(SqlSession session,String category) {
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap();
		map.put("category", category);
		return session.selectList("product.newCateList",map);
	}
	@Override
	public List<Product> selectSaleList(SqlSession session, int cPage, int numPerPage, String sort, String category) {
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap();
		map.put("sort", sort);
		return session.selectList("product.saleList",map);
	}

}
