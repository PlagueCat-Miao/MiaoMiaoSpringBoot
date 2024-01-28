package com.plague.learn.T05_LuceneTest.code;


import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

public class LuceneSimilarityExample {

    public static void main(String[] args) throws IOException {
        // 设置相似度计算方法
        Similarity similarity = new BM25Similarity();

        // 创建索引搜索器
        IndexReader reader = DirectoryReader.open(FSDirectory.open(new File("索引文件路径").toPath()));
        IndexSearcher searcher = new IndexSearcher(reader);
        searcher.setSimilarity(similarity);

        // 创建MoreLikeThis对象
        //org.apache.lucene.search.similarities.MoreLikeThis mlt = new org.apache.lucene.search.similarities.MoreLikeThis(reader);

        // 设置查询字段
        //mlt.setFieldNames(new String[]{"content"}); // "content"是你的文档字段名

        // 创建查询
        //Query query = mlt.like(0); // 0是文档ID

        // 执行查询
        //ScoreDoc[] hits = searcher.search(query, 10).scoreDocs;

        // 输出结果
//        for (ScoreDoc scoreDoc : hits) {
//            Document doc = searcher.doc(scoreDoc.doc);
//            System.out.println("相似文档: " + doc.get("id") + " 分数: " + scoreDoc.score);
//        }

        // 关闭资源
        reader.close();
    }
}