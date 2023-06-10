import request from '@/utils/request'

// 查询积分类目明细列表
export function listPointRecordItem(query) {
  return request({
    url: '/rubbish/PointRecordItem/list',
    method: 'get',
    params: query
  })
}

// 查询积分类目明细详细
export function getPointRecordItem(id) {
  return request({
    url: '/rubbish/PointRecordItem/' + id,
    method: 'get'
  })
}

// 新增积分类目明细
export function addPointRecordItem(data) {
  return request({
    url: '/rubbish/PointRecordItem',
    method: 'post',
    data: data
  })
}

// 修改积分类目明细
export function updatePointRecordItem(data) {
  return request({
    url: '/rubbish/PointRecordItem',
    method: 'put',
    data: data
  })
}

// 删除积分类目明细
export function delPointRecordItem(id) {
  return request({
    url: '/rubbish/PointRecordItem/' + id,
    method: 'delete'
  })
}
