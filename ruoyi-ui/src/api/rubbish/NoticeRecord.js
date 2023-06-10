import request from '@/utils/request'

// 查询消息发送记录列表
export function listNoticeRecord(query) {
  return request({
    url: '/rubbish/NoticeRecord/list',
    method: 'get',
    params: query
  })
}

// 查询消息发送记录详细
export function getNoticeRecord(id) {
  return request({
    url: '/rubbish/NoticeRecord/' + id,
    method: 'get'
  })
}

// 新增消息发送记录
export function addNoticeRecord(data) {
  return request({
    url: '/rubbish/NoticeRecord',
    method: 'post',
    data: data
  })
}

// 修改消息发送记录
export function updateNoticeRecord(data) {
  return request({
    url: '/rubbish/NoticeRecord',
    method: 'put',
    data: data
  })
}

// 删除消息发送记录
export function delNoticeRecord(id) {
  return request({
    url: '/rubbish/NoticeRecord/' + id,
    method: 'delete'
  })
}
