import request from '@/utils/request'

// 查询积分使用记录列表
export function listPointUseRecord(query) {
  return request({
    url: '/rubbish/PointUseRecord/list',
    method: 'get',
    params: query
  })
}

// 查询积分使用记录详细
export function getPointUseRecord(id) {
  return request({
    url: '/rubbish/PointUseRecord/' + id,
    method: 'get'
  })
}

// 新增积分使用记录
export function addPointUseRecord(data) {
  return request({
    url: '/rubbish/PointUseRecord',
    method: 'post',
    data: data
  })
}

// 修改积分使用记录
export function updatePointUseRecord(data) {
  return request({
    url: '/rubbish/PointUseRecord',
    method: 'put',
    data: data
  })
}

// 删除积分使用记录
export function delPointUseRecord(id) {
  return request({
    url: '/rubbish/PointUseRecord/' + id,
    method: 'delete'
  })
}
