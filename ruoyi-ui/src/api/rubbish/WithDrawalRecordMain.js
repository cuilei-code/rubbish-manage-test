import request from '@/utils/request'

// 查询提现记录列表
export function listWithDrawalRecordMain(query) {
  return request({
    url: '/rubbish/WithDrawalRecordMain/list',
    method: 'get',
    params: query
  })
}

// 查询提现记录详细
export function getWithDrawalRecordMain(id) {
  return request({
    url: '/rubbish/WithDrawalRecordMain/' + id,
    method: 'get'
  })
}

// 新增提现记录
export function addWithDrawalRecordMain(data) {
  return request({
    url: '/rubbish/WithDrawalRecordMain',
    method: 'post',
    data: data
  })
}

// 修改提现记录
export function updateWithDrawalRecordMain(data) {
  return request({
    url: '/rubbish/WithDrawalRecordMain',
    method: 'put',
    data: data
  })
}

// 删除提现记录
export function delWithDrawalRecordMain(id) {
  return request({
    url: '/rubbish/WithDrawalRecordMain/' + id,
    method: 'delete'
  })
}
