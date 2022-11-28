package me.seun.springbasic.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class JdbcTemplateMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemberRepository(DataSource dataSource) {
        System.out.println(dataSource.getClass());
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Member member) {
        String sql = "insert into member(name) values(?)";
        jdbcTemplate.update(sql, member.getName());
    }

    @Override
    public Optional<Member> findById(Long id) {
        String sql = "select * from member where member_id = ?";
        Member member = jdbcTemplate.queryForObject(sql, memberRowMapper(), id);
        return Optional.ofNullable(member);
    }

    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            long memberId = rs.getLong("member_id");
            String name = rs.getString("name");
            return new Member(memberId, name);
        };
    }
}
